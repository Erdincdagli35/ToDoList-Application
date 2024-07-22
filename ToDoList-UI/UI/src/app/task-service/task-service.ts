import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { UserAndTask } from '../models/UserAndTask';
import { Task } from '../models/Task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private baseURL = "http://localhost:8080/tasks";

  private deleteURL = "http://localhost:8080/tasks";

  constructor(private httpClient: HttpClient) { }

  getTaskList(): Observable<UserAndTask[]> {
    return this.httpClient.get<UserAndTask[]>(`${this.baseURL}`);
  }

  deleteTask(id: string): Observable<Object> {
    return this.httpClient.delete(`${this.deleteURL}/${id}`);
  }

  editTask(task : Task): Observable<Object> {
    return this.httpClient.put(this.baseURL, task);
  }
  
  getTaskByName(name: string): Observable<Task[]> {
    return this.httpClient.get<Task[]>(`${this.baseURL}/${name}`);
  }

  addTaskByName(task: Task, name: string): Observable<Task> {
    return this.httpClient.put<Task>(`${this.baseURL}/${name}`, task);
  }

 /* login(user: User): Observable<any> {
    return this.httpClient.post<any>(this.loginURL, user);
  }

  signUp(user: User): Observable<any> {
    return this.httpClient.post<any>(this.singUpURL, user);
  }

 

  getUserByName(name: string): Observable<User> {
    return this.httpClient.get<User>(`${this.baseURL}/${name}`);
  }
  
  

  removeToShelf(id : number, shelfIds : number[]): Observable<Object>{
    return this.httpClient.delete(`${this.removeToShelfURL}/${id}/${shelfIds}`);
  }

  removeAllShelves(id : number): Observable<Object>{
    return this.httpClient.delete(`${this.removeAllShevesURL}/${id}`);
  }*/
}