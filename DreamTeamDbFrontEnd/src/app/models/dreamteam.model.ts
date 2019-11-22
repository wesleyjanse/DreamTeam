import { Observable } from 'rxjs';

export class Dreamteam {
    constructor(public id: number,
        public naam: string,
        public userId: number,
        public spelersId?: Observable<number>
        ) { }
}