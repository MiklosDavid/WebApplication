import { Component, OnInit } from '@angular/core';
import { Task } from "../task";
import { TaskService } from '../task.service';

@Component({
  selector: 'app-task-list',
  templateUrl: './task-list.component.html',
  styleUrls: ['./task-list.component.css']
})
export class TaskListComponent implements OnInit {
  public filteredTasks: Task[];
  public selectedStatus: string;
  public selectedTask: Task;

  private tasks: Task[] = [];

  constructor(
    private taskService: TaskService
  ) { 
  }

  async ngOnInit(): Promise<void> {
    this.selectedStatus = '';
    this.tasks = await this.taskService.getTasks();
    this.filter();
  }

  onFilterChange(status: string): void {
    this.selectedStatus = status;
    this.filter();
  }

  onSelectTask(task: Task): void {
    this.selectedTask = task;
  }

  async onFormSubmit(task: Task): Promise<void> {
    if (task.id > 0) {
      await this.taskService.updateTask(task)
      this.selectedTask.username = task.username; 
      this.selectedTask.category = task.category;
      
    } else {
      this.selectedTask.id = Math.floor(Math.random()*1000000);
      
      this.selectedTask.username = task.username; 
      this.selectedTask.category = task.category;
     
      this.selectedTask.status = 'NEW';
      this.taskService.createTask(task)
                        .then(createdTask => {
                          this.tasks.push(createdTask);
                        });
    }
    this.selectedTask = null;
  }
  
  onNewClick(): void {
    this.selectedTask = new Task();
  }
  
  onDeleteClick(id: number) {
    this.taskService.deleteTask(id)
    .then(async () => {
      this.selectedTask = null;
      this.tasks = await this.taskService.getTasks();
      this.filter();
    })
  }

  private filter(): void {
    this.filteredTasks = this.selectedStatus === ''
    ? this.tasks
    : this.tasks.filter(task => task.status === this.selectedStatus);
  }
}
