import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from '../models/user';
import { UserService } from '../user-service/user-service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-user-delete',
  templateUrl: './user-delete.component.html',
  styleUrls: ['./user-delete.component.css']
})
export class UserDeleteComponent {
  user: User = new User();
  users: User[] = [];

  constructor(
    private userService: UserService, 
    private activatedRoute: ActivatedRoute, 
    private router: Router
  ) {}

  ngOnInit(): void {
    this.user.id = this.activatedRoute.snapshot.params['id'];
    console.log(`this.user.id: ${this.user.id}`);
    this.userService.deleteUser(this.user.id).subscribe(data => {
      this.goToList();
    });
  }

  goToList() {
    this.router.navigate(['/user-list']);
  }
}
