export class User   {
    constructor(
        public firstName: string,
        public email: string,
        public mobile: string,
        public password: string,
        public country: string,
        public gender: string,
        public subscribe: boolean
    ) {}
}