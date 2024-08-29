import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { LoginResponse } from '../types/login-response.type';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  constructor(private httpClient: HttpClient) { }

  login(name: string, password: string) {
    return this.httpClient.post<LoginResponse>("/loging", { name, password }).pipe(
      // tap to get a synchronous value
      tap((value) => sessionStorage.setItem("auth-token", value.token),
        (value) => sessionStorage.setItem("username", value.name))
    );
  }
}
