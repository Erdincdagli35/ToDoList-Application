import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { User } from '../models/user';
import { UserPasswordChangePojo } from '../models/UserPasswordChangePojo';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private baseURL = "http://localhost:8080/users";

  private loginURL = "http://localhost:8080/users/login";
  private singUpURL = "http://localhost:8080/users/singUp";
  private deleteURL = "http://localhost:8080/users";
  private changePasswordURL = "http://localhost:8080/users/changePassword";

  private userName: string = '';
  
  constructor(private httpClient: HttpClient) { }

  getUserList(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.baseURL);
  }

  login(user: User): Observable<any> {
    return this.httpClient.post<any>(this.loginURL, user);
  }

  signUp(user: User): Observable<any> {
    return this.httpClient.post<any>(this.singUpURL, user);
  }

  deleteUser(id: string): Observable<Object> {
    return this.httpClient.delete(`${this.deleteURL}/${id}`);
  }

  passwordChange(userPCP : UserPasswordChangePojo): Observable<Object> {
    return this.httpClient.put(this.changePasswordURL, userPCP);
  }

  getUserByName(name: string): Observable<User> {
    return this.httpClient.get<User>(`${this.baseURL}/${name}`);
  }
  
  getUserById(id: string): Observable<User> {
    return this.httpClient.get<User>(`${this.baseURL}/${id}`);
  }

  setUserName(name: string) {
    this.userName = name;
  }

  getUserName(): string {
    return this.userName;
  }

  /*

  removeToShelf(id : number, shelfIds : number[]): Observable<Object>{
    return this.httpClient.delete(`${this.removeToShelfURL}/${id}/${shelfIds}`);
  }

  removeAllShelves(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.removeAllShevesURL}/${id}`);
  }*/
}