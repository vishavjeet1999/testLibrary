import AwesomeLibrary from './NativeAwesomeLibrary';

export function multiply(a: number, b: number): number {
  return AwesomeLibrary.multiply(a, b);
}

export function square(a: number): number {
  return AwesomeLibrary.square(a);
}
