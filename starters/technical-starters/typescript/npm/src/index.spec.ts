import { sayHello } from './index';

test('sayHello can greet a user', (): void => {
    // Given
    const user = { name: 'TypeScript' };

    // When then
    expect(sayHello(user)).toBe('Hello TypeScript!');
});
