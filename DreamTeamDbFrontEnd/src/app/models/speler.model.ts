export class Speler {
    constructor(public naam: string, 
        public userId: number,
        public positie: string,
        public teamId?: number,
        public id?: string, 
        public spelerId?: number) { }
}