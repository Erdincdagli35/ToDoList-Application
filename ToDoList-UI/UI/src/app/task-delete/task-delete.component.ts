import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Router } from '@angular/router';

import { TaskService } from '../task-service/task-service';
import { UserAndTask } from '../models/UserAndTask';
import { Task } from '../models/Task';

@Component({
  selector: 'app-task-delete',
  templateUrl: './task-delete.component.html',
  styleUrls: ['./task-delete.component.css']
})
export class TaskDeleteComponent {

  userAndTasks: UserAndTask = new UserAndTask();
  userAndTask: UserAndTask[] = [];

  task: Task = new Task();
  tasks: Task[] = [];

  constructor(
    private taskService: TaskService, 
    private activatedRoute: ActivatedRoute, 
    private router: Router
  ) {}

  ngOnInit(): void {
    this.task.id = this.activatedRoute.snapshot.params['id'];
    console.log(`this.task.id: ${this.task.id}`);
    this.taskService.deleteTask(this.task.id).subscribe(data => {
      this.goToList();
    });
  }

  goToList() {
    this.router.navigate(['/task-list']);
  }

}
