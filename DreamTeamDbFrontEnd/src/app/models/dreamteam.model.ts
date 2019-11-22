import { Observable } from 'rxjs';

export class Dreamteam {
    constructor(
        public naam: string,
        public userId: number,
        public id?: string,
        public spelersId?: Observable<number[]>
        ) { }
}