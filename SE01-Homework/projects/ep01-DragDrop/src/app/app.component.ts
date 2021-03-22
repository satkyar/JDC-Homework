import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styles: []
})

export class AppComponent {
  title = 'Drag & Drop Feature';

  from = ["Javascript","Typescript","Angular","Spring"]

  to: string[] =   []

  dragged: any

  num: number = 0

  private dragValue?: string

  drag(event: any) {
    this.dragged = event.target
    this.dragValue = event.target?.innerText
    event.target.style.backgroundColor = "black"
    event.target.style.color = "white"
    event.target.style.opacity = "0.5"
  }

  toggle = true;

  drop(event: any) {
    if(event.target.id.includes("to") && this.dragValue && !this.dragged.id.includes("to")) {
      this.to.push(this.dragValue)
      this.from = this.from.filter(a => a != this.dragValue)
      this.dragValue = undefined
    }
    else if(event.target.id.includes("from") && this.dragValue && ! this.dragged.id.includes("from")) {
      this.from.push(this.dragValue)
      this.to = this.to.filter(a => a != this.dragValue)
      this.dragValue = undefined
    }
    else{
      this.dragged.style.backgroundColor = "white"
      this.dragged.style.color = "black"
      this.dragged.style.opacity = "1"
    }
  }

  bgChange(event: any){
    this.dragged.style.backgroundColor = "white"
    this.dragged.style.color = "black"
    this.dragged.style.opacity = "1"
  }
}
