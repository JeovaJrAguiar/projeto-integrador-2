import { Component } from '@angular/core';
import { AccountServiceService } from '../../services/account-service/account-service.service';
import { Account } from '../../entities/account.model';
import { StorageService } from '../../services/storage/storage.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {
  accountInstance: Account | undefined;
  userName: string = 'User';
  mail: string = 'user@user.com';

  totalEntradas: number = 0.0;
  totalSaidas: number = 0.0;
  totalAtual: number = 0.0;


  constructor(
    private accountService: AccountServiceService,
    private router: Router,
    private localStorage: StorageService
  ){}
  ngOnInit(): void {
    var authorization = this.localStorage.get('authorization');

    if(authorization  == null){
      this.userName = 'Authorization not found';
      this.router.navigate(['/login']);
    }else{
      const decodedCredentials = atob(authorization);
      const [mail, _] = decodedCredentials.split(':');

      this.mail = mail;
      this.accountService.getUserInfo(mail).subscribe(
        (response) => {
          this.accountInstance = Account.fromJsonObj(response);
          this.userName = this.accountInstance.username;

          
        },
        (error) => {
          console.error('Erro ao obter informações do usuário:', error);
        }
      );

      this.accountService
    }
  }
}
