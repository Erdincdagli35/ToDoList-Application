import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TaskListAllAdminComponent } from './task-list-all-admin.component';

describe('TaskListAllAdminComponent', () => {
  let component: TaskListAllAdminComponent;
  let fixture: ComponentFixture<TaskListAllAdminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TaskListAllAdminComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TaskListAllAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
