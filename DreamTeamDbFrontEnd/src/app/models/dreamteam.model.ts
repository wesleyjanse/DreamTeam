import { Observable } from 'rxjs';

export class Dreamteam {
    constructor(
        public naam: string,
        public userId: string,
        public id?: string,
        public spelersId?: Observable<string>
        ) { }
}