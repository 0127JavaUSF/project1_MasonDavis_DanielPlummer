export class NewClaim {
  constructor(
    public amount: number,
    public reason: string,
    public image: Blob
  ) {}
}
