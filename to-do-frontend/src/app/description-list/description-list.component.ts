import { Component, OnInit } from '@angular/core';
import { Description } from "../description";
import { DescriptionService } from '../description.service';

@Component({
  selector: 'app-description-list',
  templateUrl: './description-list.component.html',
  styleUrls: ['./description-list.component.css']
})
export class DescriptionListComponent implements OnInit {
  public filteredDescriptions: Description[];
  public selectedStatus: string;
  public selectedDescription: Description;

  private descriptions: Description[] = [];

  constructor(
    private descriptionService: DescriptionService
  ) { 
  }

  async ngOnInit(): Promise<void> {
    this.selectedStatus = '';
    this.descriptions = await this.descriptionService.getDescriptions();
    
  }

  }

