import { Component } from '@angular/core';
import { Router } from '@angular/router';

import { User } from 'src/app/models/user';
import { UserService } from '../user-service/user-service';
import { UserReturnPojo } from 'src/app/models/userReturnPojo';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent {
    users : User[] = [];
    user : User = new User();
    
    constructor(private userService:UserService, 
                private router:Router){}

    ngOnInit(): void {
      //this.getAllLibrary();
      this.getUser();
    }
  
    private getUser(){
      this.userService.getUserList().subscribe(data => {
        this.users = data;
      });
    }

    getAllUser(){
      this.router.navigate(['/user-list']);
    }

    deleteUser(id : string){
      this.router.navigate(['/user-delete',id]);
    }

    passwordChange(name: string){
      this.router.navigate(['/user-password-change',name]);
    }

/*
    saveLibrary(library: Library){
      this.router.navigate(['/library-create']);
    }

   

    detailsLibrary(id: number){
      this.router.navigate(['/library-details',id]);
    }

    addToShelf(id : number){
      this.router.navigate(['/library-add-to-shelf',id]);
    }

    removeAllShelves(id : number){
      this.router.navigate(['/library-remove-all-shelves', id]);
    }*/
}
