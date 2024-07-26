import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { TaskService } from '../task-service/task-service';
import { UserService } from '../user-service/user-service';

import { UserAndTask } from '../models/UserAndTask';
import { Task } from '../models/Task';
import { Status } from '../models/Status';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent {
  userAndTasks : UserAndTask[] = [];
  userAndTask : UserAndTask = new UserAndTask();

  task : Task = new Task();
  tasks : Task[] = [];

  statusFilter: Status | null = null; 
  titleFilter: string = '';

  loggedUserName : string = "";

  constructor(private taskService:TaskService, 
              private userService:UserService,
              private router:Router){}

  ngOnInit(): void {
      this.getTaskByName(); 
  }

  private getTaskByName() {
    const currentUserName = this.userService.getUserName();
    const currentUserNameString: string = currentUserName.toString();
    console.log("currentUserNameString : " + currentUserNameString);
    this.loggedUserName = currentUserName;

    const status = this.statusFilter !== null ? this.statusFilter : undefined;
    const title = this.titleFilter !== '' ? this.titleFilter : undefined;

    this.taskService.getTaskByName(currentUserNameString, status, title).subscribe(data => {
      console.log("data : " + data);
      this.tasks = data;
      console.log("this.tasks : " + this.tasks);
  });
  }

  addTask(){
    this.router.navigate(['/task-add']);
  }

  deleteTask(id : string){
    this.router.navigate(['/task-delete',id]);
  }

  updateTask(id : string) {
    this.router.navigate(['/task-edit',id]);
  }
  goToTaskList(){
    this.router.navigate(['/task-list-by-user']);
  }

  applyFilter() {
    this.getTaskByName();  // Fetch tasks based on the selected filter
  }
}
