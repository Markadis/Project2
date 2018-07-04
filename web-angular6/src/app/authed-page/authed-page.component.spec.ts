import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthedPageComponent } from './authed-page.component';

describe('AuthedPageComponent', () => {
  let component: AuthedPageComponent;
  let fixture: ComponentFixture<AuthedPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthedPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthedPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
