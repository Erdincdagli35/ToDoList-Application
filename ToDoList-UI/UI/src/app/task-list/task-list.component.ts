import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { TaskService } from '../task-service/task-service';
import { UserService } from '../user-service/user-service';

import { User } from '../models/user';
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

  tasks : Task[] = [];
  task : Task = new Task();

  constructor(private taskService:TaskService, 
              private userService:UserService,
              private router:Router,
              private activatedRoute: ActivatedRoute){}

  ngOnInit(): void {
      this.getTaskByName(); // Parametre alındıktan sonra veri al
  }

  /*
  private getTasks(){
  this.taskService.getTaskList().subscribe(data => {
      this.userAndTasks = data;
    });
    console.log("this.userAndTasks : " + this.userAndTasks);
  }
*/

private getTaskByName(): void {
  const currentUserName = this.userService.getUserName();
  console.log("currentUserName : " + currentUserName);
  //this.userAndTask.name = this.activatedRoute.snapshot.params[currentUserName];
  //console.log("userAndTask.name : " + this.userAndTask.name);
  const currentUserNameString: string = currentUserName.toString();

  this.taskService.getTaskByName(currentUserNameString).subscribe(data => {
    this.tasks = data;
    console.log("this.userAndTask : " + this.userAndTask);
});
}

  deleteTask(id : string){
    console.log("In deleteTask");
    this.router.navigate(['/task-delete',id]);
  }

  updateTask(){
    this.router.navigate(['/task-edit']);
  }
}
