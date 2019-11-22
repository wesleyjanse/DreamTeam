export class Member {
    constructor(
        public id: number,
        public username: string,
        public password: string,
        public role: string,
        public token: string
        ) { }
}