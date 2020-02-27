import { Component, OnInit } from '@angular/core';
import { SectionServiceService } from '../service/section-service.service';
import { Router, RouterLink, RouterEvent } from '@angular/router';
import { Subscriber } from 'rxjs';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  usernameInput = '';
  passwordInput = '';
  user = document.getElementsByName('username');

  constructor() { }

  ngOnInit(): void {
  }

  login() {
    console.log('buuuuttttttonnnnn');
}
}
