import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UserGetByIdComponent } from './user-get-by-id.component';

describe('UserGetByIdComponent', () => {
  let component: UserGetByIdComponent;
  let fixture: ComponentFixture<UserGetByIdComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UserGetByIdComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(UserGetByIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
