import { Injectable } from '@angular/core';
import { Task } from "./task";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService, httpOptions } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class TaskService {
  
  private taskUrl: string = 'http://localhost:8080/tasks';

  constructor(
    private http: HttpClient,
    private authService: AuthService 
  ) { }

  getTasks(): Promise<Task[]> {
    return this.http.get<Task[]>(`${this.taskUrl}`, httpOptions).toPromise();
  }

  getTask(id: number): Promise<Task> {
    return this.http.get<Task>(`${this.taskUrl}/${id}`, httpOptions).toPromise();
  }

  createTask(task: Task): Promise<Task> {
    return this.http.post<Task>(`${this.taskUrl}`, task, httpOptions).toPromise();
  }

  updateTask(task: Task): Promise<Task> {
    return this.http.put<Task>(`${this.taskUrl}/${task.id}`, task, httpOptions).toPromise();
  }

  deleteTask(id): Promise<Task> {
    return this.http.delete<Task>(`${this.taskUrl}/${id}`, httpOptions).toPromise();
  }
}