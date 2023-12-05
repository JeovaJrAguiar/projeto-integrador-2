import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Account } from '../../entities/account';
import { tap } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private API_USER_LOGIN: string = 'http://localhost:8080/api/account/login';

  constructor(private http: HttpClient) { }

  login(mail: string, password:string) {
    const httpOptions = {
        headers: { Authorzation: "Basic " + btoa(mail + ':' + password) }
    };

    return this.http.get<Account>(this.API_USER_LOGIN + `/${mail}`).pipe(
      tap((response: Account) => {
        return response;
      })
    );
  }
}
