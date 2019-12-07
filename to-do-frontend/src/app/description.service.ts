import { Injectable } from '@angular/core';
import { Description } from "./description";
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthService, httpOptions } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class DescriptionService {
  
  private descriptionUrl: string = 'http://localhost:8080/descriptions';

  constructor(
    private http: HttpClient,
    private authService: AuthService 
  ) { }

  getDescriptions(): Promise<Description[]> {
    return this.http.get<Description[]>(`${this.descriptionUrl}`, httpOptions).toPromise();
  }

  getDescription(id: number): Promise<Description> {
    return this.http.get<Description>(`${this.descriptionUrl}/${id}`, httpOptions).toPromise();
  }

  createDescription(description: Description): Promise<Description> {
    return this.http.post<Description>(`${this.descriptionUrl}`, description, httpOptions).toPromise();
  }

  updateDescription(description: Description): Promise<Description> {
    return this.http.put<Description>(`${this.descriptionUrl}/${description.id}`, description, httpOptions).toPromise();
  }

  deleteDescription(id): Promise<Description> {
    return this.http.delete<Description>(`${this.descriptionUrl}/${id}`, httpOptions).toPromise();
  }
}