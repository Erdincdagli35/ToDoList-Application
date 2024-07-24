import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { TaskService } from '../task-service/task-service';
import { UserService } from '../user-service/user-service';

import { UserAndTask } from '../models/UserAndTask';
import { Task } from '../models/Task';

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
    
    this.taskService.getTaskByName(currentUserNameString).subscribe(data => {
      console.log("data : " + data);
      this.tasks = data;
      console.log("this.tasks : " + this.tasks);
  });
  }

  deleteTask(id : string){
    this.router.navigate(['/task-delete',id]);
  }

  updateTask(){
    this.router.navigate(['/task-edit']);
  }

  goToTaskList(){
    this.router.navigate(['/task-list-by-user']);
  }
}
