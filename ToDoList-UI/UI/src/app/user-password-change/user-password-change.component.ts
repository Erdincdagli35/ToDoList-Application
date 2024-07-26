import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ActivatedRoute } from '@angular/router';

import { UserService } from '../user-service/user-service';
import { UserPasswordChangePojo } from '../models/UserPasswordChangePojo';
import { User } from '../models/user';

@Component({
  selector: 'app-user-password-change',
  templateUrl: './user-password-change.component.html',
  styleUrls: ['./user-password-change.component.css']
})
export class UserPasswordChangeComponent {

  userPCPTemp : UserPasswordChangePojo = new UserPasswordChangePojo();
  userPCP : UserPasswordChangePojo = new UserPasswordChangePojo();

  user : User = new User();
  userTemp : User = new User();

    constructor(private userService : UserService, 
                private activatedRoute: ActivatedRoute, 
                private router: Router){}

    ngOnInit(): void {
      const userName = this.activatedRoute.snapshot.params['userName'];    
      console.log("userName : " + userName);

      if (userName) {
        this.userService.getUserByName(userName).subscribe(
          (data: User) => {
            this.userTemp = data;
            console.log("this.userTemp.id " + this.userTemp.id);
          },
          (error) => console.log(error)
        );
      }
    }

    onSubmit(){
       console.log("onSubmit : user : " + this.userPCP.name);
      this.userService.passwordChange(this.userPCP)
                         .subscribe(data => {
        console.log("updateuser");
        this.goToList();
      },
      error => console.log(error));
    }

    goToList() {
      this.router.navigate(['/main-dashboard']);
    }

}
