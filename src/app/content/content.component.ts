import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-content',
  templateUrl: './content.component.html',
  styleUrls: ['./content.component.css']
})
export class ContentComponent implements OnInit {

  constructor(private http: HttpClient) { }

  ngOnInit(): void {
  }

  logout() {
    return this.http.delete<any>('http://localhost:8080./Project11/LoginController');
  }
}
