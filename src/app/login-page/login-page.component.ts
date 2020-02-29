import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../service/login-service.service';
import { Router, RouterLink, RouterEvent } from '@angular/router';
import { Subscriber, Observable, observable } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  usernameInput = '';
  passwordInput = '';

  user = [];

  constructor(private loginService: LoginServiceService) { }


  ngOnInit(): void {

  }
  /*ngOnInit(): void {
    this.loginService
    .loginObservable$.subscribe(item => {

        this.user.push(this.usernameInput, this.passwordInput);
    });
  }*/

  login() {
    console.log('buuuuttttttonnnnn');
}
}
