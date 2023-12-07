import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { StorageService } from '../storage/storage.service';
import { catchError, throwError } from 'rxjs';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AccountServiceService {
  private API_USER_INFO: string = 'http://localhost:8080/api/account';


  constructor(
    private http: HttpClient,
    private localStorage: StorageService,
    private router: Router
  ) { }

  getUserInfo(mail: string) {
    const authorization = this.localStorage.get('authorization');

    if (!authorization) {
      this.router.navigate(['/login']);
      return throwError('Authorization not found in localStorage');
    }

    const headers = {
      Authorization: 'Basic ' + authorization
    };

    const apiUrl = `${this.API_USER_INFO}/user-info/${mail}`

    return this.http.get(apiUrl).pipe(
      catchError(error => {
        console.error('Erro ao obter informações do usuário:', error);
        return throwError(error);
      })
    );
  }

  getTotalEntradas(mail: string) {
    const authorization = this.localStorage.get('authorization');

    if (!authorization) {
      this.router.navigate(['/login']);
      return throwError('Authorization not found in localStorage');
    }

    const headers = {
      Authorization: 'Basic ' + authorization
    };

    const apiUrl = `${this.API_USER_INFO}/user-info/${mail}`

    return this.http.get(apiUrl).pipe(
      catchError(error => {
        console.error('Erro ao obter informações do usuário:', error);
        return throwError(error);
      })
    );
  }
}
