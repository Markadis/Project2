import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  onUserInput() {
    let len = 0;
    document.getElementById('userMax').addEventListener('keypress', () => {
      len = document.getElementById('userMax').innerText.length;
    });
    return len;
  }

  constructor() { }

  ngOnInit() {
  }
}
