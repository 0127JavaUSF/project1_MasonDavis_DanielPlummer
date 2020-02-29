import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';


export interface User {
  username: string;
  password: string;
}

@Injectable({
  providedIn: 'root'
})
export class LoginServiceService {

  constructor(private httpClient: HttpClient) { }

  login(input: string): Promise<User> {

    const url = 'http://localhost:8080/Project11/SubmitServlet';
    return this.httpClient.get<User>(url).toPromise();

  }


}
