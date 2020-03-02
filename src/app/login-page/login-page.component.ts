import { Component, OnInit } from '@angular/core';
import { LoginServiceService } from '../service/login-service.service';
import { Router, RouterLink, RouterEvent } from '@angular/router';
import { Subscriber, Observable, observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  employee = {username: '', password: ''};

  constructor(private http: HttpClient) { }

  ngOnInit(): void {}

  login() {
    return this.http.post<any>('http://localhost:8080/Project11/LoginController', {
      username: this.employee.username,
      password: this.employee.password
    }).subscribe(
      data => (console.log('Success')),
      error => (console.log('Error'))
    );
  }


}
