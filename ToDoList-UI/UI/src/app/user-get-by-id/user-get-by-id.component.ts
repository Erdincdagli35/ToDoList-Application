import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { UserService } from '../user-service/user-service';
import { User } from '../models/user';

@Component({
  selector: 'app-user-get-by-id',
  templateUrl: './user-get-by-id.component.html',
  styleUrls: ['./user-get-by-id.component.css']
})
export class UserGetByIdComponent {
  user : User = new User();

  constructor(private activetedRoute: ActivatedRoute, 
              private router: Router,
              private userService:UserService){}

  ngOnInit(): void {
    this.user.id = this.activetedRoute.snapshot.params['id'];

    this.userService.getUserById(this.user.id).subscribe(data => {
      this.user = data;
  });
  }

}
