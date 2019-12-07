export class Task {
    public id: number = 0;
    public username: string = '';
    public category: string = '';
    public status: string = 'NEW'; 
    public created_at: Date =  new Date(); 
    public updated_at: Date =  new Date();
}
