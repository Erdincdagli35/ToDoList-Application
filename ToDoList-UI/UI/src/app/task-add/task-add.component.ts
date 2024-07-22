import { Component } from '@angular/core';

import { Task } from '../models/Task';
import { Status } from '../models/Status';
import { User } from '../models/user';
import { TaskService } from '../task-service/task-service';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../user-service/user-service';

@Component({
  selector: 'app-task-add',
  templateUrl: './task-add.component.html',
  styleUrls: ['./task-add.component.css']
})
export class TaskAddComponent {
  task : Task = new Task();

  taskStatus: { status: Status } = { status: Status.NoProgress };
  statuses: string[] = Object.values(Status);

  user: User = new User();

  userName : string = "";

  constructor(private taskService: TaskService, 
              private userService: UserService,
              private activetedRoute: ActivatedRoute, 
              private router: Router){}

  ngOnInit(): void {
    this.userName = this.userService.getUserName();
    this.addToTask(this.userName);
  }

  addToTask(userName : string){
    this.taskService.addTaskByName(this.task,userName).subscribe(data => {
      this.goToTaskList();
    })
  }

  goToTaskList() {
    this.router.navigate(['task-list']); 
  }
  
  onSubmit() {
    console.log(this.task);
    this.addToTask(this.userName);
  }

}
