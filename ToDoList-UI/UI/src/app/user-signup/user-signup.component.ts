import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';

import { User } from 'src/app/models/user';
import { UserReturnPojo } from 'src/app/models/userReturnPojo';
import { UserService } from '../user-service/user-service';

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSingupComponent {
  user: User = new User();

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {
  }

  saveUser() {
    this.userService.signUp(this.user).subscribe(data => {
      console.log(data);
      this.goToHome();
    },
      error => console.log(error));
  }

  goToHome() {
    this.router.navigate(['']); 
  }
  
  onSubmit() {
    console.log(this.user);
    this.saveUser();
  }
}