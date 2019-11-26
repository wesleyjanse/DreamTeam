import { Dreamteam } from './dreamteam.model';
import { Speler } from './speler.model';
import { Member } from './member.model';

export class DreamteamMetSpelersEnUsers {
    constructor(
        public dreamTeam: Dreamteam,
        public spelers: Speler[],
        public user: Member
        ) { }
}