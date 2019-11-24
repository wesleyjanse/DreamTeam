import { Dreamteam } from './dreamteam.model';
import { Speler } from './speler.model';

export class DreamteamMetSpelers {
    constructor(
        public dreamTeam: Dreamteam,
        public spelers: Speler[]
        ) { }
}