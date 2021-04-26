import axios from "axios";

const API_URL = 'http://localhost:8080/';

class AuthService {
    register(user) {
        return axios.post(API_URL + 'signup', {
            name: user.name,
            surname: user.surname,
            password: user.password,
            repeatPassword: user.repeatPassword,
            email: user.email
        });
    }

    login(user) {
        return axios
            .post(API_URL, {
                email: user.email,
                password: user.password
            })
            .then(response => {
                if (response.data.accessToken) {
                    localStorage.setItem('user', JSON.stringify(response.data));
                }

                return response.data;
            });
    }

    logout() {
        localStorage.removeItem('user');
    }
}

export default new AuthService();