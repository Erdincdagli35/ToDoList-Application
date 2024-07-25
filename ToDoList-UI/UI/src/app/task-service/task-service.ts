import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

import { UserAndTask } from '../models/UserAndTask';
import { Task } from '../models/Task';
import { Status } from '../models/Status';

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
  
  getTaskByName(userName: string, status?: Status): Observable<Task[]> {
    const statusParam = status ? `&status=${status}` : '';
    return this.httpClient.get<Task[]>(`${this.baseURL}/${userName}?${statusParam}`);
  }
  
  addTaskByName(task: Task, name: string): Observable<Task> {
    return this.httpClient.post<Task>(`${this.baseURL}/addTaskToUser/${name}`, task);
  }
}