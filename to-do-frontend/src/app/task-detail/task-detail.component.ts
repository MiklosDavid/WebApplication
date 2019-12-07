import { Component, OnInit } from '@angular/core';
import { Task } from '../task';
import { ActivatedRoute } from '@angular/router';
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-detail',
  templateUrl: './task-detail.component.html',
  styleUrls: ['./task-detail.component.css']
})
export class TaskDetailComponent implements OnInit {
  
  public task: Task = null;

  constructor(
    private route: ActivatedRoute,
    private taskService: TaskService
  ) { }
  
  async ngOnInit(): Promise<void> {
    const id = +this.route.snapshot.paramMap.get('id');
    this.task = await this.taskService.getTask(id);
  } 

}
