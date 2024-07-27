import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { TaskService } from '../task-service/task-service';
import { UserService } from '../user-service/user-service';

import { UserAndTask } from '../models/UserAndTask';
import { Task } from '../models/Task';
import { Status } from '../models/Status';

@Component({
  selector: 'app-task-list-all-admin',
  templateUrl: './task-list-all-admin.component.html',
  styleUrls: ['./task-list-all-admin.component.css']
})
export class TaskListAllAdminComponent {
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
      this.getTaskList(); 
  }

  private getTaskList() {
    const currentUserName = this.userService.getUserName();
    const currentUserNameString: string = currentUserName.toString();
    console.log("currentUserNameString : " + currentUserNameString);
    this.loggedUserName = currentUserName;

    const status = this.statusFilter !== null ? this.statusFilter : undefined;
    const title = this.titleFilter !== '' ? this.titleFilter : undefined;
    
    this.taskService.getTaskList(status, title).subscribe(data => {
      console.log("data : " + data);
      this.tasks = data;
      console.log("this.tasks : " + this.tasks);
  });
  }

  goToTaskList(){
    this.router.navigate(['/task-list']);
  }

  applyFilter() {
    this.getTaskList();  
  }
}
