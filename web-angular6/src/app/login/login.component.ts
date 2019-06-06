import {Component, OnInit, ViewChild, AfterViewInit} from '@angular/core';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  @ViewChild('child') private onChange;

  constructor() {
  }

  ngOnInit() {
    document.getElementById('password').addEventListener('keypress', function () {
      document.getElementById('register').style.opacity = '1.0';
      document.getElementById('register').disabled = false;
    });
  }

  onPasswordEnter() {
  }
}
