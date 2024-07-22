import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserListNameComponent } from './user-list-name.component';

describe('UserListNameComponent', () => {
  let component: UserListNameComponent;
  let fixture: ComponentFixture<UserListNameComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserListNameComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserListNameComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
