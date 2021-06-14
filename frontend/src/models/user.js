export default class User {
    constructor(name, surname, password, repeatPassword, email, avatar) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.repeatPassword = repeatPassword;
        this.email = email;
        this.roles = [];
        this.avatar = avatar;
    }

}