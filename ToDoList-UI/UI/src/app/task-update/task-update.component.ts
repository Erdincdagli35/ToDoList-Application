import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { TaskService } from '../task-service/task-service';
import { Task } from '../models/Task';
import { Status } from '../models/Status';

@Component({
  selector: 'app-task-update',
  templateUrl: './task-update.component.html',
  styleUrls: ['./task-update.component.css']
})
export class TaskUpdateComponent {

  taskTemp : Task = new Task();
  task : Task = new Task();

  taskStatus: { status: Status } = { status: Status.NoProgress };
  statuses: string[] = Object.values(Status);

    constructor(private taskService : TaskService, 
                private activatedRoute: ActivatedRoute, 
                private router: Router){}

    ngOnInit(): void {
      const taskId = this.activatedRoute.snapshot.params['id'];    
      console.log("taskId : " + taskId);

      if (taskId) {
        this.taskService.getTaskById(taskId).subscribe(
          (data: Task) => {
            this.taskTemp = data;
            console.log("this.taskTemp.id " + this.taskTemp.id);
          },
          (error) => console.log(error)
        );
      }
    }

    onSubmit(){
      this.taskService.editTask(this.taskTemp)
                         .subscribe(data => {
        console.log("updateuser");
        this.goToList();
      },
      error => console.log(error));
    }

    goToList() {
      this.router.navigate(['/task-list-by-user']);
    }
}
