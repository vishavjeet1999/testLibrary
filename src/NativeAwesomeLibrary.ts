import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  multiply(a: number, b: number): number;
  square(a: number): number;
  getBatteryHealth(): Promise<string>;
}

export default TurboModuleRegistry.getEnforcing<Spec>('AwesomeLibrary');
