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
  userTemp : User = new User();

  taskStatus: { status: Status } = { status: Status.NoProgress };
  statuses: string[] = Object.values(Status);

  user: User = new User();
  tasks : Task[] = [];

  statusFilter: Status | null = null; 
  userName : string = "";
  loggedUserName : string = "";

  constructor(private taskService: TaskService, 
              private userService: UserService,
              private activatedRoute: ActivatedRoute, 
              private router: Router){}

  ngOnInit(): void {
    const currentUserName = this.userService.getUserName();
    
    const currentUserNameString: string = currentUserName.toString();
    console.log("currentUserNameString : " + currentUserNameString);
    this.loggedUserName = currentUserName;

    if (this.loggedUserName) {
      this.userService.getUserByName(this.loggedUserName).subscribe(
        (data: User) => {
          this.userTemp = data;
          console.log("this.userTemp.id " + this.userTemp.id);
        },
        (error) => console.log(error)
      );
    }
  }

  goToTaskList() {
    this.router.navigate(['/task-list-by-user']);
  }
  
  onSubmit() {
    const currentUserName = this.userService.getUserName();
    console.log("currentUserName : " + currentUserName);

    const currentUserNameString: string = currentUserName.toString();
    console.log("currentUserNameString : " + currentUserNameString);


    this.taskService.addTaskByName(this.task,currentUserNameString).subscribe(data => {
      this.goToTaskList();
    })
  }

}
