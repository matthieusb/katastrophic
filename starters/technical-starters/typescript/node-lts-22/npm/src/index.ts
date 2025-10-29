interface User {
    name: string;
}

export function sayHello(user: User): string {
    return `Hello ${user.name}!`;
}
